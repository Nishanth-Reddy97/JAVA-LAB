import java.util.*;
class Gen<T,V>
{
T tob;
V vob;
Gen(T O,V U)
{
tob=O;
vob=U;
}
T gettob()
{
return tob;
}
V getvob()
{
return vob;
}
void ShowType()
{
System.out.println("Type of T is"+tob.getClass().getName());
System.out.println("Type of T is"+vob.getClass().getName());
}
}

class GenDemo1{
public static void main(String args[])
{
Gen<Integer,Double>tgobj;
tgobj=new Gen<Integer,Double>(88,11.0);
tgobj.ShowType();
int v=tgobj.gettob();
System.out.println("Auto unboxed value is"+" "+v);
double w=tgobj.getvob();
System.out.println("Auto unboxed value is"+" "+w);
}
}
