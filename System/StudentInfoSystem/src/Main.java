import java.util.Scanner;

class Main 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add mAdd = new Add(); 
		Update mUpdate = new Update();
		Delete mDelete = new Delete();
		View mView = new View();
		
		int num = 0;
		int id = 0; 
		String name="";
		String department="";
		String phone=""; 		 // inputs from the user
	
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
	
		
		do{
		System.out.println("************************");
		System.out.println("1.	Add Student		");
		System.out.println("2. 	Update Student	");
		System.out.println("3.	Delete Student	");
		System.out.println("4. 	View Student 	");
		System.out.println("5.  	Exit        ");
		System.out.println("************************");
		System.out.println("번호를 선택해 주세요 : ");
		num = sc.nextInt();
		
			if (num == 1){
				System.out.println("*Add Student");
				System.out.println("학생 아이디(숫자) :");
				id = sc.nextInt();
				System.out.println("이름 :");
				name = sc1.nextLine();
				System.out.println("소속 :");
				department = sc1.nextLine();
				System.out.println("핸드폰 번호 :");
				phone = sc1.nextLine();
			    mAdd.addStudent(id, name, department, phone);
			   }
			else if (num == 2){

				System.out.println("*Update Student");
				System.out.println("업데이트하려는 학생 아이디 :");
				id = sc.nextInt();
				System.out.println("핸드폰 번호 :");
				phone = sc1.nextLine();
			    mUpdate.updateStudent(id, phone);
			    }
			else if (num == 3){

				System.out.println("*Delete Student");
				System.out.println("삭제하려는 학생 아이디 :");
				id = sc.nextInt();

				mDelete.deleteStudent(id);
				}
			else if (num == 4){
				System.out.println("*View Student");
				System.out.println("학생 아이디 :");
			   id = sc.nextInt();
			   mView.viewStudent(id);
			}
			else 
				System.exit(0);
		} while (true);
	}
}