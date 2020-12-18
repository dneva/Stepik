import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(10);

        while (sc.hasNext()){
            try {
                list.add(sc.nextInt());
            }catch (Exception e){
                break;
            }

        }
        int count=0;
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            Integer next=iterator.next();
            if(count%2==0){
                iterator.remove();
            }
            count++;
        }
        Collections.reverse(list);
        list.forEach((i)->System.out.printf("%d ",i));
        sc.close();
    }
}
