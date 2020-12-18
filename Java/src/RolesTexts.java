import java.util.Arrays;
import static java.lang.System.*;

    public class RolesTexts {

        private static String printTextPerRole(String[] roles, String[] textLines) {
            int count=1;

        for (int i = 0;i < roles.length;i++){
            roles[i]=roles[i].concat(":");
        }

        StringBuilder[] ans = new StringBuilder[roles.length];
        StringBuilder[] lines = new StringBuilder[textLines.length];

        Arrays.setAll(ans, i -> new StringBuilder(roles[i]));
        Arrays.setAll(lines, i -> new StringBuilder(textLines[i]));

        for(int j=0;j<textLines.length;j++){
            for(int i = 0;i < roles.length;i++){
                if(textLines[j].startsWith(roles[i])){
                    ans[i].append('\n');
                    ans[i].append(lines[j].replace(0,roles[i].length(),String.valueOf(count)+')'));
                    count++;
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(StringBuilder s : ans) {
            builder.append(s);
            builder.append('\n');
            builder.append('\n');
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String[] roles={"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles,textLines));

    }
}
