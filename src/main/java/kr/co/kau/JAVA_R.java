package kr.co.kau;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;
import org.rosuda.REngine.REXPString;

public class JAVA_R {
	public static void main(String[] args) {
		Rengine re = new Rengine(new String[]{"--vanilla"}, false, null);
		System.out.println("Rengine created, wating for R");

		if(!re.waitForR()){
			System.out.println("Cannot load R");
			return;
		}
		/*		
//		re.eval("install.packages(\"tm\")", true);
		re.eval("library(tm)", true);
		re.eval("sms_raw <- read.csv(\"C:/sms_spam.csv\",stringsAsFactors = FALSE,encoding=\"UTF-8\")", true);
		re.eval("str(sms_raw)", true);
		re.eval("sms_raw$type<-factor(sms_raw$type)", true);
//		re.eval("str(sms_raw$type)", true);
//		re.eval("table(sms_raw$type)", true);
		re.eval("sms_corpus <- Corpus(VectorSource(sms_raw$text))", true);
//		re.eval("sms_corpus[[1]]$content", true);
//		re.eval("sms_corpus[[10]]$content", true);
		re.eval("corpus_clean <- tm_map(sms_corpus,content_transformer(tolower))", true);
		re.eval("corpus_clean <- tm_map(corpus_clean,removeNumbers)", true);
		re.eval("corpus_clean <- tm_map(corpus_clean,removePunctuation)", true);
		re.eval("corpus_clean <- tm_map(corpus_clean,removeWords,stopwords())", true);
		re.eval("corpus_clean <- tm_map(corpus_clean,stripWhitespace)", true);
		re.eval("sms_dtm <- DocumentTermMatrix(corpus_clean)", true);
//		re.eval("sms_dtm", true);
//		re.eval("#inspect(sms_dtm)", true);
//		REXP rexp = re.eval("corpus_clean[[1]]$content", true);
//		System.out.println(rexp);
		re.eval("sms_raw_train <- sms_raw[1:4069, ]", true);
		re.eval("sms_raw_test <- sms_raw[4070:5571, ]", true);

		re.eval("sms_dtm_train <- sms_dtm[1:4069, ]", true);
		re.eval("sms_dtm_test <- sms_dtm[4070:5571, ]", true);

		re.eval("sms_corpus_train <- corpus_clean[1:4069]", true);
		re.eval("sms_corpus_test <- corpus_clean[4070:5571]", true);

//		re.eval("prop.table(table(sms_raw_train$type))", true);
//		re.eval("prop.table(table(sms_raw_test$type))", true);

//		re.eval("install.packages(\"wordcloud\")",true);
//		re.eval("library(wordcloud)", true);

//		re.eval("wordcloud(sms_corpus_train, min.freq = 40, random.order=FALSE)", true);

//		re.eval("spam <- subset(sms_raw_train, type==\"spam\")", true);
//		re.eval("ham <- subset(sms_raw_train, type==\"ham\")", true);

//		re.eval("wordcloud(spam$text, max.words=40, scale=c(3,0.5))", true);
//		re.eval("wordcloud(ham$text, max.words=40, scale=c(3,0.5))", true);

		re.eval("sms_dict <- findFreqTerms(sms_dtm_train,5)", true);
		re.eval("sms_train <- DocumentTermMatrix(sms_corpus_train,list(dictionary=sms_dict))", true);
		re.eval("sms_test <- DocumentTermMatrix(sms_corpus_test,list(dictionary=sms_dict))", true);

//		re.eval("write.table(table(sms_test$type),\"C:/Users/user/Documents/RJAVA/op.txt\", sep = \",\", row.name = FALSE, quote = FALSE, append = TRUE)", true);
		REXP rexp = re.eval("sms_test[[1]]", true);
		System.out.println(rexp); 
		re.eval("convert_counts <- function(x) {", true);
		re.eval("  x <- ifelse(x > 0, 1, 0)", true);
		re.eval("  x <- factor(x, levels = c(0, 1), labels = c(\"No\", \"Yes\"))", true);
		re.eval("  return (x)", true);
		re.eval("}", true);

		re.eval("sms_train <- apply(sms_train, MARGIN=2, convert_counts)", true);
		re.eval("sms_test <- apply(sms_test, MARGIN=2, convert_counts)", true);

		re.eval("library(\"e1071\")",true);

		re.eval("sms_classifier <- naiveBayes(sms_train, sms_raw_train$type)",true);
		re.eval("sms_test_pred <- predict(sms_classifier, sms_test)",true);*/

		re.eval("library(mlbench)",true);
		re.eval("data(HouseVotes84, package = \"mlbench\")",true);
		re.eval("library(e1071,character.only = TRUE)",true);
		re.eval("model <- naiveBayes(Class ~ ., data = HouseVotes84)",true);
		re.eval("predict(model, HouseVotes84[1:10,])",true);
		re.eval("predict(model, HouseVotes84[1:10,], type = \"raw\")",true);
		re.eval("pred <- predict(model, HouseVotes84)",true);
		re.eval("table(pred, HouseVotes84$Class)",true);

		REXP rexp = re.eval("pred[1]",true);
		System.out.println(rexp);
		rexp = re.eval("model[1]",true);
		System.out.println(rexp);
		rexp = re.eval("HouseVotes84[1]",true);
		System.out.println(rexp);
		System.out.println("End ...");


		//		re.eval("library(gmodels)", true);
		//		re.eval("CrossTable(sms_test_pred, sms_raw_test$type, prop.chisq = FALSE, prop.t = FALSE, dnn = c('predicted','actual'))", true);

	}
}
