# 环境的安装与配置

  1. mysql安装与配置----卸载    
  2. jdk ( 32 )
   安装 一路默认
   java   javac ...
   系统环境变量的配置
    JAVA_HOME:jdk安装路径
    classpath: .  当前路径
    path:java命令所在目录
    jdk安装目录/bin;jdk的安装目录/jre/bin
   eclipse: 免安装  
   解压：第一次使用时的配置信息会在今后使用中生效，但是如果我们更换了工作空间
   那么所有的配置需要从新设置

# eclipse基本配置

   1. 更改编码格式
   ```
      window--->pre--->搜索框中输入 encoding 回车
      workspace---》utf-8
      css----》utf-8
      html---->utf-8
      jsp-----》utf-8
      xml---->utf-8
   ```
   2. 设置字体大小以及样式
   ```
     window---->pre--->gen--->点击color and  font ---> 右边出现basic
     text  font 
     服务器 ip
     ipconfig:  系统终端  ip 192.168.13.5
     http:127.0.0.1:8888
  ```
----------------------------------------

# java基本语法

1. 类的创建与对象的创建
  模板（语法）
```
   [修饰符]  class   类名/合法标示符{
     //属性/成员变量
     [修饰符]  数据类型  属性名/合法标示符;
     //方法 普通方法   构造器
     //普通方法
     [修饰符]  返回类型  方法名/合法标示符(参数列表/局部变量){
         代码的重用与封装
        return   返回值类型;
     }
     //构造器
     修饰符  方法名(参数列表){
     //初始化对象
     }
      //代码块
      {}
      //静态代码块
      static{
      } 
   }
```
   1. 修饰符：
      两种：
      范围修饰
```
      public：所有的类和对象都可以访问--》公共汽车
      
      protected ：包权限 默认
      private：私有的  只有当前类中可以访问
              --->私家车

     public  class Test{}
     class Test{}
     private Test{} 错误的
      类名  方法  成员属性
```
     其他修饰符：
 ```
        static :静态修饰符  
	如果是静态的内容，那么在类加载的过程中静态内容就会被加载，同时构建空间存储,所以所有的静态内容都不依托对象而存在
	final:常量 
	public  final  int  num  =10;
	num =20; //错误的
```
2. 合法标示符（名字）：要求
   类名 方法名 属性名..<br/>
   开头必须是 字母 _  $<br/>
   组成  字母 数字 _  $<br/>
   长度没有限制<br/>
   不能是java中的关键字 和保留字<br/>
   严格区分大小写<br/>
   
   命名规范：
   类名/接口名： 首字母大写  驼峰式命名<br/>
     Student  Teacher  ClassRoom<br/>
   属性名/方法名：首字母小写 驼峰式命名<br/>
    userName  password  getName...<br/>
   常量:USER_NAME(只读属性)<br/>
   
2. 属性：
    两者之间的位置的不同局决定了属性特性的
    不同<br/>
    成员属性（成员变量）<br/>
    局部属性（局部变量）<br/>
    声明语法：    
```
    [修饰符]  数据类型  名字 [=value] ;
    数据类型：（设置数据在内存中的保存形式） 
    基本数据类型：
     数值类型：
        byte  short  int  long (整数)
        float  double (浮点数  小数)
     字符类型：
        char(特殊的整数类型)
        boolean
    引用数据类型：
       类类型
       接口类型
       数组类型
```
 2. 数据类型彼此之间是可以相互转换的
 ```
   两种： 隐士数据类型装换
   从一种较小的数据类型---->较大的数据类型
   byte a =10;//8
   int b  =a;//32
   long c  =b;
   显示数据类型转换：
   较大的数据----->较小的数据格式接受
   int  a =3328;
   byte  b  =(byte)a;(-128-- 127  -2^7  - 2^7-1)

   long   a  =10000;
   byte b  =(byte)a;

  public  class   Test{
    //属性写在方法的外面 类的里面 成员属性/成员变量
    //所有的成员变量在我们没有显示初始化的时候
    //jvm会默认给他们赋值 数值 0  引用 null  boolean  false
    //声明周期  成员变量而言只要有对象就可以使用
    public  int  a;
   //写在方法里面的 或者是方法里面的代码块里面的
   //这些统称为局部变量
   public  void test(){
   //1.所有的局部变量虚拟机都不会进行初始化
   //所以想要使用需要我们自己进行初始化
   //生命周期  所有局部变量的声明周期 都是从
   //声明这个变量开始到这个变量所直接属于的{}
   结束
     int  a  =10;//局部变量
     if(a==10){
      int b  =20;//局部变量
     }
   }
  }
```
 3. 方法的定义
 ```
   [修饰符]  返回类型  方法名(参数列表){
       return XXX;
   }
   修饰符：public  static  顺序是可变的
   public  static  void main(){}
   返回类型：必须放置在方法名的前面
   有什么样的数据类型返回类型就可以写什么
   数据类型（
   基本 引用:要求方法内部必须存在return语句
   而且return语句后面数据的数据类型必须和返回类型
   声明的数据类型保持一致
   void）
   public   int  买水1(){
      syso("下楼")
      syso("游过小池塘")
      return 1;
   }

    public   Student  test2(){
      return  new Student()
   }

  void : 
     public  void   goSleep(){
        可以添加return ;
	不添加return也没问题
     }   

     public  class BanZhang{
       public void  buyWater(){
        //事故  没水了
	if(!有水){
	return ;}
	syso();
       }
     }
     return : 返回一个结果给方法的调用者
              快速结束一个方法的执行
  //买水  把钱给班长  喝那个牌子的水
  参数列表： 将方法运行时需要使用的参数进行传递
   public  String getWarter(double money,String logo){
   }
  参数列表的分类：
      形参：方法声明过程中的参数叫形参
      实参: 调用的时候传递的参数叫做实参

      getWarter(100,"农夫山泉");
      参数传递根据数据类型的不同具有不同的特性
      基本数据类型：参数传递过程中传递的是值本身
      引用数据类型：传递的是对象的地址
```
---------------------------------------------------

# java的条件循环语句
 1. 条件判断
 ```
    逻辑操作
   
   三目运算符：
      boolean类型的表达式?如果为true:为false执行
      int  a =10;//赋值
      > < >= <=  equals  &&  ||  &  |
  if(boolean 类型表达式){
      执行该内容
  }else{
  }

  if(boolean 类型的表达式){}else if(boolean表达式){
  }else if(boolean表达式){
  }else{} 
 
  switch ..case 

  switch(int/long/char){
    case  one:
       XXXX;
       break;
    case  two:
       XXXX;
       break;
     default:
       xxxxxxx;
       break;
  }

1.获取每个月的天数
1 3 5 7 8 10 12 ------》31
4 6 9 11---------------》30
2 ---》平年 28  闰年   29


 2.循环:重复性的操作
   1.初始条件
   2.结束条件
   3.迭代条件
   4.循环体

   for(初始条件;结束条件;迭代){
     循环体;
   }
   for(int  i =0;i<10;i++){
   }
while循环：
   初始条件;
   while(结束条件){
      循环体;
      迭代部分;
   }
   int  a =10;
   while(a<100){
   syso(a);
   a++;
   }

   do..while
   初始条件
   do{
     循环体;
     迭代条件
   }while(结束条件);
 增强for :数组 或是集合


 集合
 for(Object o : 数组/集合){
   syso(o)
 }

```

   



   

