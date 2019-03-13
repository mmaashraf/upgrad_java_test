import java.util.*;  
class Student{
	String name;
	double cgpa;
	int token;
	Student(String n,double cg,int token){
		this.name=n;
		this.cgpa=cg;
		this.token=token;
	}
	public String toString(){
		return  this.name+"\t"+this.cgpa+"\t"+this.token;
	}
}
class Mycomparator implements Comparator<Student>{
		public int compare(Student stu_one,Student stu_two){
			int cgpa=Double.compare(stu_one.cgpa,stu_two.cgpa);
		if(cgpa!=0){
			return cgpa;
		}
		int name=(stu_one.name).compareTo(stu_two.name);
		if(name!=0){
			return -name;//required is ascending order for name,negative since lower the number higher the priority
		}
		int token= Integer.compare(stu_one.token,stu_two.token);
		return -token;//negative since lower the number higher the priority
			
	}	
}	
public class Main{
	public static boolean isEnter(String x){
		if(x.equals("ENTER")){
			return true;
		}
		else
			return false;
	}
	public static boolean isServed(String x){
		if(x.equals("SERVED")){
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[]) throws Exception{
		List<Student> q=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("enter events and details");
	for(int i=0;i<n;i++){
		String event=sc.next();
		if(isEnter(event)){
			//read name,cg,token
			String name=sc.next();
			double cgpa=sc.nextDouble();
			int token=sc.nextInt();
			q.add(new Student(name,cgpa,token));
			
			
		}
		else if(isServed(event)){
			
			if(q.size()!=0){
			
				q.remove(q.size()-1);
			}
			else{
				System.out.println("there's no student in queue to serve");
			}
			
		}
		else{
			System.out.println("enter correct event : either SERVED or ENTER");
		}
		Collections.sort(q,new Mycomparator());
		
		//System.out.println("array  is \n"+q);
	}
	if( q.isEmpty() ){
		System.out.println("EMPTY");
	}
	else{
	
	//print the remaining unserved students
		for(int i=q.size()-1;i>=0;i--){
			System.out.println(q.get(i).name);
		}
	}
	sc.close();
	}
}