import java.util.*;
public class ClassWork2 {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(101,"Akshat");
        map.put(102,"Akshay");
        map.put(103,"Shivang");
        map.put(104,"Aditya");
        map.put(105,"Nitin");
        System.out.println(map);
        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println("Roll No: " + entry.getKey() + "  Name: " + entry.getValue());
        }
        map.remove(102);
        System.out.println(map);
        int search=104;
        String name=map.get(search);
        System.out.println("Student with roll number  " + search + " " +name);



    }
    
}
