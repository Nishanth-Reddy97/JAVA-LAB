//single parameter
import java.util.*;
class Gen<T>
{
T ob;
Gen(T O)
{
ob=O;
}
T getob()
{
return ob;
}
void ShowType()
{
System.out.println("Type of T is"+ob.getClass().getName());
}
}
class GenDemo{
public static void main(String args[])
{
Gen<Integer>iob;
iob=new Gen<Integer>(88);
iob.ShowType();
int v=iob.getob();
System.out.println("Auto unboxed value is"+" "+v);
}
}
