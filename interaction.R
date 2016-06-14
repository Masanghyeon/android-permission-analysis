arg <- commandArgs()   
arg

dir.path <- arg[6] #"C:\Users\Curycu\workspace\BoxR"

Cmd <- parse(text = arg[7])
Cmd

library(tm)
sms_raw <- read.csv("C:/sms_spam.csv",stringsAsFactors = FALSE,encoding="UTF-8")
#str(sms_raw)
sms_raw$type<-factor(sms_raw$type)
#str(sms_raw$type)
#table(sms_raw$type)
sms_corpus <- Corpus(VectorSource(sms_raw$text))
#sms_corpus[[1]]$content
#sms_corpus[[10]]$content
corpus_clean <- tm_map(sms_corpus,content_transformer(tolower))
corpus_clean <- tm_map(corpus_clean,removeNumbers)
corpus_clean <- tm_map(corpus_clean,removePunctuation)
corpus_clean <- tm_map(corpus_clean,removeWords,stopwords())
corpus_clean <- tm_map(corpus_clean,stripWhitespace)
#corpus_clean[[1]]$content
sms_dtm <- DocumentTermMatrix(corpus_clean)
sms_dtm
#inspect(sms_dtm)

sms_raw_train <- sms_raw[1:4069, ]
sms_raw_test <- sms_raw[4070:5571, ]

sms_dtm_train <- sms_dtm[1:4069, ]
sms_dtm_test <- sms_dtm[4070:5571, ]

sms_corpus_train <- corpus_clean[1:4069]
sms_corpus_test <- corpus_clean[4070:5571]

#prop.table(table(sms_raw_train$type))
#prop.table(table(sms_raw_test$type))


#library("wordcloud")

#wordcloud(sms_corpus_train, min.freq = 40, random.order=FALSE)

#spam <- subset(sms_raw_train, type=="spam")
#ham <- subset(sms_raw_train, type=="ham")

#wordcloud(spam$text, max.words=40, scale=c(3,0.5))
#wordcloud(ham$text, max.words=40, scale=c(3,0.5))

sms_dict <- findFreqTerms(sms_dtm_train,5)
sms_train <- DocumentTermMatrix(sms_corpus_train,list(dictionary=sms_dict))
sms_test <- DocumentTermMatrix(sms_corpus_test,list(dictionary=sms_dict))
#inspect(sms_train)
convert_counts <- function(x) {
  x <- ifelse(x > 0, 1, 0)
  x <- factor(x, levels = c(0, 1), labels = c("No", "Yes"))
  return (x)
}

sms_train <- apply(sms_train, MARGIN=2, convert_counts)
sms_test <- apply(sms_test, MARGIN=2, convert_counts)

#str(sms_train)

library("e1071")

sms_classifier <- naiveBayes(sms_train, sms_raw_train$type)
sms_test_pred <- predict(sms_classifier, sms_test)

library("gmodels")
CrossTable(sms_test_pred, sms_raw_test$type, prop.chisq = FALSE, prop.t = FALSE, dnn = c('predicted','actual'))

write.csv(sms_test_pred,"C:\workspace\android-permission-analysis\op.csv")