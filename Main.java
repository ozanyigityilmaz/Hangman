package homework;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException 
	{
		DoubleLinkedList dll =new DoubleLinkedList();
		dll.add("a");dll.add("b");dll.add("c");dll.add("d");dll.add("e");dll.add("f");dll.add("g");dll.add("h");
		dll.add("i");dll.add("j");dll.add("k");dll.add("l");dll.add("m");dll.add("n");dll.add("o");dll.add("p");
		dll.add("q");dll.add("r");dll.add("s");dll.add("t");dll.add("u");dll.add("v");dll.add("w");dll.add("x");
		dll.add("y");dll.add("z");
		int temp=0;
		int control=4;
		MultiLinkedList mll = new MultiLinkedList();
		String fileName = "input.txt";
		if (fileName.equalsIgnoreCase("input.txt"))
		{
			File file = new File("C:\\Users\\ozan\\Desktop\\input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
			String st;
			mll.addRow(control);
			while ((st = br.readLine()) != null) 
			{
				st=st.replace('I', 'i');
				st=st.toLowerCase();
				temp=st.length();	
				String converttemp=Integer.toString(temp);
				if(mll.Search(temp))
				{
					mll.addColumn(converttemp, st);	
				}
				else
				{
					mll.addRow(temp);
					mll.addColumn(converttemp, st);	
				}
							
											
			}			
		}
		mll.Display();
		Random rnd=new Random();
		int whoseword=rnd.nextInt(164);
		RowNode word=mll.getHead();
		String finalword=null;
		int count=0;
		int finalcount=0;
		boolean flag=true;
		while(word!=null&&flag==true)
		{
			ColumnNode word2=word.getRight();
			while(word2!=null)
			{
				if(count==whoseword)
				{
					finalword=word2.getData();
					flag=false;
					break;
				}
				count++;
				word2=word2.getNext();
			}	
			word=word.getDown();
			
				
		}
		System.out.println("Randomly generated number: "+whoseword);
		System.out.println(finalword);
		CircularLinkedList csll1 =new CircularLinkedList();
		CircularLinkedList csll2 =new CircularLinkedList();
		
		for(int i=0;i<finalword.length();i++)
		{
			csll1.Add(finalword.substring(i,i+1));
		}
		for(int i=0;i<finalword.length();i++)
		{
			csll2.Add("-");
		}
		//csll1.display();
		//csll2.display();
		boolean flag1=false;
		int live=6;
		int score=0;
		Scanner input=new Scanner(System.in);
		boolean charcontrol=false;
		while(flag1==false)
		{
			int startcount=0;
			NodeDouble alf1=dll.getHead();
			System.out.print("Word: ");
			csll2.display();
			System.out.print("               "+"Lives: "+live+"                "+"Score: "+score+"                ");
			dll.Display();
			System.out.print("Guess: ");
			String guess=input.next();	
			for(int i=0;i<26;i++)
			{
				if(alf1.getData().equals(guess))
				{
					break;
				}
				else
					startcount++;
				
			}
			if(guess.length()>1||guess.length()==0)
			{
				System.out.println("You must entered char");
				charcontrol=true;// controllere sayı girilirse hata vermesini yap
			}
			boolean alfflag=false;
			if(startcount<=12)
			{
				NodeDouble alf=dll.getHead();
				for(int i=0;i<26;i++)
				{
					if(alf.getData().equals(guess))
					{
						alf.setData(" ");
						alfflag=true;
						break;											
					}	
					alf=alf.getNext();
				}			
			}
			else
			{
				NodeDouble alf=dll.getTail();
				for(int i=0;i<26;i++)
				{
					if(alf.getData().equals(guess))
					{
						alf.setData(" ");
						alfflag=true;
						break;											
					}	
					alf=alf.getPrev();
				}			
			}
			
			if(alfflag==false&&charcontrol==false)
			{
				System.out.println("You entered the same letter before.");
			}
			guess=guess.toLowerCase();
			boolean controlflag=false;
			CLLNode controltemp=csll1.getHead();
			CLLNode controltemp1=csll2.getHead();
			for(int i=0;i<csll2.size();i++)
			{
				if(guess.equals(controltemp.getData())&&alfflag==true)
				{
					controltemp1.setData(guess);
					finalcount++;
					controlflag=true;
					if(guess.equals("a")||guess.equals("e")||guess.equals("i")||guess.equals("o")||guess.equals("u"))
					{
						score+=5;
					}
					else
					{
						score+=10;
					}
				}
				controltemp1=controltemp1.getLink();
				controltemp=controltemp.getLink();
					
			}
			if(controlflag==false&&alfflag==true)
			{
				live--;
				
			}
			if(live==0)
			{				
				flag1=true;
				break;
			}
			if(finalcount==finalword.length())
			{
				flag1=false;
				break;
			}
		
		}
		if(flag1==true)
		{
			System.out.println("Game Over");
			System.out.println("the word you didn't know was: "+finalword);
		}
		else 
		{
			System.out.println("Congratulations!!");		
		}
		System.out.print("Word: ");
		csll2.display();
		System.out.print("               "+"Lives: "+live+"                "+"Score: "+score+"                ");
		dll.Display();
		SingleLinkedList sll=new SingleLinkedList();	
		String []player=new String[2];
		String filename = "HighScoreTable.txt";
		if (filename.equalsIgnoreCase("HighScoreTable.txt"))
		{
			File file = new File("C:\\Users\\ozan\\Desktop\\HighScoreTable.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
			String st;
			while ((st = br.readLine()) != null) 
			{
				player=st.split(";");
				int playerscore=Integer.parseInt(player[1]);
				Gamer playerx=new Gamer(player[0],playerscore);
				sll.insert(playerx);
			}		
		}
		System.out.print("Enter your name: ");
		String playername=input.next();	
		Gamer User=new Gamer(playername,score);
		sll.insert(User);
		System.out.println("High Score Table");
		Node sllsave=sll.getHead();
		File file=new File("C:\\Users\\ozan\\Desktop\\HighScoreTable.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter fileWriter=new FileWriter (file,true);
		BufferedWriter bWriter=new BufferedWriter(fileWriter);
		while(sllsave!=null)
		{
			bWriter.write("\n"+((Gamer) sllsave.getData()).getName()+";"+((Gamer) sllsave.getData()).getScore());
			sllsave=sllsave.getLink();
		}
		bWriter.close();
		sll.display();
	}
}
