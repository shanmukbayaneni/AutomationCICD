package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    //@Test
    public void regular() {

        List<String> names = new ArrayList<String>();
        names.add("mani");
        names.add("mavi");
        names.add("jai");
        names.add("kill");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("m")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter()
    {
        List<String> names = new ArrayList<String>();
        /*names.add("mani");
        names.add("mavi");
        names.add("jai");
        names.add("kill");*/

        //[there is no life for intermediate op if there is no terminal op]
        //[terminal operation will e ]xecute only if inter op(filter) returns true
        //[we can create stream]
        //how to use filter in stream API

        Long c=names.stream().filter(s->s.startsWith("m")).count();
        System.out.println(c);

        Long c1=Stream.of("mani","mavi","jai","kill").filter(s->
        {
            s.startsWith("m");
            return true;
        }).count();
        System.out.println(c1);


        //print all the names of arraylist
        names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));
    }
    @Test
    public void streamMap()
    {
        List<String> names1 = new ArrayList<String>();
        names1.add("mani");
        names1.add("mavi");
        names1.add("jail");
        names1.add("kevin");
        names1.add("jim");
        //print names which have last letter as "A" with uppercase
        Stream.of("mani","mavi","jai","kill").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));

        //print names which have first letter as a with uppercase and sorted

        List<String> nam=Arrays.asList("mani","mavi","jail","kevin","jim");
        nam.stream().filter(s->s.startsWith("M")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        //merging 2 different lists
        Stream<String> ns=Stream.concat(names1.stream(),nam.stream());
        //ns.forEach(s-> System.out.println(s));

        boolean flag=ns.anyMatch(s->s.equalsIgnoreCase("Mavi"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }
    @Test //to collect data and convert it into any list
    public void streamCollect()
    {
        List<String> ls=Stream.of("mani","mavi","jani","kevi","jimmi").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));


        //

        List<Integer> num= Arrays.asList(3,2,2,7,5,1,9,7);
        //print unique number form this array
        //sort the array - 3rd index - 1,2,3,5,7,9

        num.stream().distinct().forEach(s-> System.out.println(s));
        List<Integer>in =num.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(in.get(2));
    }



}

