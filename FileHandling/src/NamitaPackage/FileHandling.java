
	package NamitaPackage;
	
	
	import java.util.Scanner;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.Arrays;
	
	
	
		public class FileHandling {
		

		public static void main(String[] args) {
			
			// Creation of Folder
			
			  System.out.println("Enter the path to the directory, excluding the directory name inside which file operations will be performed. \n\n: ");  
		      Scanner input = new Scanner(System.in);  
		      String path = input.next();  
		      
		      //Using Scanner class to get the folder name from the user  
		      System.out.println("Enter the name of the directory inside which file operations need to be performed. \n\n: "); 
		      String folder = input.next();
		      
		      path = path + "\\" + folder;
		      
			  File f1 = new File(path);        
		      //Creating a folder  
		 		  
			  
			  try
			  {if (!f1.exists()){
				    f1.mkdirs();
				}
			  System.out.println("Folder is created successfully .\n\n");  
			  }
			  catch(Exception ee) {	         
		      
		         System.out.println("Folder was not created!! \n"); 
		         ee.printStackTrace();
		         
		       }		      
		      
		      //
		      System.out.println("YOU ARE INSIDE THE FILE HANDLING APPLICATION!!! \n");
		      int  SelectCase;
		      SortingFile filesort = new SortingFile();
		      int terminateflag = 0;
		      
		      do {
		    	  System.out.println("Select the Operation to be performed\n\n 1. Retrive files from main Folder in asscending order \n 2. File Operations \n 3. Terminate the program sucessful\n\n:");
		    	  SelectCase = input.nextInt();
		    	  
		    	  switch(SelectCase) {
		    	  
		    	  case 1: // Retrieve all files in ascending order .
		    		  filesort.filesSort(path);
		    		  break;
		    		  
		    	  case 2: // File Operations
		    		  System.out.println("File Operations \n");
		    		  OperationOnFile obj = new OperationOnFile();
		    		  terminateflag = obj.fileoperations(path);
		    		  break;
		    		  
		    	  case 3:  // Terminate The Applications .
		    		  break;
		    		  
		    	  default :
		    		  System.out.println("Enter option correctly and try again.... \n\n");
		    	  
		    	  }
		    	  
		    	  if(terminateflag == 1)
		    		  SelectCase = 3;
		    		  
		    	  
		      } while(SelectCase != 3);
		      
		      input.close();		      
		      System.out.println("Application has been Terminated !!");
		         

	      }
	}

		
		
		class SortingFile {

		    public void filesSort(String dirPath)
		    {
		       	      
		        File folder = new File(dirPath);
		        if(folder.isDirectory())
		        {
		            File[] fileList = folder.listFiles();

		            Arrays.sort(fileList);

		            System.out.println("\nTotal number of items present in the directory: " + fileList.length );


		            // Lists only files since we have applied file filter
		            for(File file:fileList)
		            {
		                System.out.println(file.getName());
		            }

		        }   
		    }
		}
		
		
		
		
	class OperationOnFile{
		
		int fileoperations(String path) {
			
			int SelectCase = 0;
			Scanner input = new Scanner(System.in);
			File file = new File("");
			String fileName ;
			
			do {
				System.out.println("Enter the desired number to perform corresponding operation :\n \n 1. Add a file: \n 2. Delete a file: \n 3. Display Files starting with same name. \n 4. Return to previous menu :\n 5. Terminate the Application. \n\n:");
				
				SelectCase = input.nextInt();
				switch(SelectCase) {
				
				case 1: //Creation of File.
					
					System.out.println("Provide a filename with the EXTENTION for creation of file: ");
					fileName = input.next();
					file = new File(path, fileName);
					 try {
						if(file.createNewFile()) 
						{
							System.out.println("Congratulations!!! File has been created Sucessfully. ");
						}
												
					} catch (Exception e) {
						
						System.out.println("File was not created, please check the stack trace. ");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case 2: // Deletion of File.
					
					System.out.println("Enter the filename to delete :");
				    fileName = input.next();
					file = new File(path, fileName);
					try {
						if(file.delete())					
			        {
			            System.out.println("File has been deleted successfully"+ file.getName());
			        }
						
					}
						catch (Exception e1) {
			       
			            System.out.println("Failed to delete the file");
			            e1.printStackTrace();
			        }
					
					break;
					
				case 3: // Display the Files with given name in the provided folder.
					
					System.out.println("Enter the string to be matched :");
				    String string = input.next();
					File folder = new File(path);
					File[] filelist = folder.listFiles();
					ArrayList <String> list = new ArrayList<String>();
					for(File f:filelist) {
						list.add(f.getName());
					}
					System.out.println("Files starting with :" + string );
					for(String l:list) {
						if(l.contains(string))
							System.out.println(l);
					}
				
					break;
					
				case 4: // Return to Previous Menu
					SelectCase = 5;
					break;
				case 5:  // Terminate the application .
					return 1;
					
				default :
					System.out.println(" Enter correct number and try again ..... \n");
					break;
				}
				
			}while(SelectCase != 5) ;
			
			input.close();
			
			return 0;
		}
		
	}
	
	
	
	
	


