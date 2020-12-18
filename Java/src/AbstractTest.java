public class AbstractTest {
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
    interface TextAnalyzer {
        Label processText(String text);
    }
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(TextAnalyzer analyzer : analyzers){
            Label res=analyzer.processText(text);
            if(res!=Label.OK){
                return res;
            }
        }
        return Label.OK;
    }
    abstract static class KeywordAnalyzer implements TextAnalyzer{
        abstract protected String[] getKeywords();
        abstract protected Label getLabel();
        public Label processText(String text){
            for (String keyword : getKeywords()){
                System.out.println(keyword);
                if(text.contains(keyword)){
                    return this.getLabel();
                }
            }
        return Label.OK;
        }
    }
    static class SpamAnalyzer extends KeywordAnalyzer{
        private String[] keywords;
        public SpamAnalyzer(String[] keywords){
            this.keywords=keywords;
        }
        public String[] getKeywords(){
            return keywords;
        }
        public Label getLabel(){
            return Label.SPAM;
        }
    }
    static class NegativeTextAnalyzer extends KeywordAnalyzer{
        private String[] keywords=new String[]{":(","=(",":|"};
        public String[] getKeywords(){
            return keywords;
        }
        public Label getLabel(){
            return Label.NEGATIVE_TEXT;
        }
    }
    static class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        public TooLongTextAnalyzer(int maxLength){
            this.maxLength=maxLength;
        }
        @Override
        public Label processText(String text) {
            if(text.length()>maxLength){
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }
    public static void main(String[] args) {
        SpamAnalyzer sp = new SpamAnalyzer(new String[]{"first", "second"});
        TextAnalyzer[] analyzers = new TextAnalyzer[]{sp};
        String text="this is third test, and it is not spam";
        System.out.println(AbstractTest.checkLabels(analyzers, text));


    }
}
