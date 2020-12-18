public class GenericsTest {
     static class Pair<T,S>{
        private T number;
        private S str;
        private Pair(T number,S str){
            this.number=number;
            this.str=str;
        }
        public static <T,S> Pair<T,S> of(T number, S str){
            return new Pair<>(number,str);
        }

         public T getFirst() {
             return number;
         }

         public S getSecond() {
             return str;
         }

         @Override
         public boolean equals(Object obj) {
            if (this==obj) return true;
            if (obj instanceof  Pair<?,?>)
            {
                if (((Pair<?,?>)obj).getFirst()!=null && ((Pair<?,?>)obj).getSecond()!=null)
                    return  ((Pair<?,?>)obj).getFirst().equals(number) && ((Pair<?,?>)obj).getSecond().equals(str);
                else if(((Pair<?,?>)obj).getSecond()==null && ((Pair<?,?>)obj).getFirst()!=null)
                    return  ((Pair<?,?>)obj).getFirst().equals(number) && str==null;
                else if  (((Pair<?,?>)obj).getFirst()==null && ((Pair<?,?>)obj).getSecond()!=null)
                    return ((Pair<?,?>)obj).getSecond().equals(str) && number==null;
                else return true;
            }
            return false;
         }

         @Override
         public int hashCode() {
            if (number!=null && str!=null)
             return number.hashCode()+str.hashCode();
            else if (number!=null)
                return number.hashCode();
            else if (str!=null)
                return str.hashCode();
            return 0;
         }
     }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, null);
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(null, null);
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}
