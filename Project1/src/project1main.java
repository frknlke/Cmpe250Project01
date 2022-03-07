
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class project1main {

    public static void main(String[] args)throws IOException {
// System.out.println("MyFileIO - read input file");
			String inputFileName = args[0];
			File myInputFile = new File(inputFileName);
        ArrayList<House> houses = new ArrayList<House>();
        ArrayList<Student> students = new ArrayList<Student>();

			try {
				Scanner sc = new Scanner(myInputFile);
                sc.useLocale(Locale.US);
				while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    Scanner myReader = new Scanner(line);
                    myReader.useLocale(Locale.US);
                    String indicator = myReader.next();
                    if(indicator.equalsIgnoreCase("h")){
                            int id = myReader.nextInt();
                            int duration = myReader.nextInt();
                            double rating = myReader.nextDouble();
                            houses.add(new House(id,duration,rating));
                    }
                    else if(indicator.equalsIgnoreCase("s")){
                            int id  = myReader.nextInt();
                            String name = myReader.next();
                            int duration = myReader.nextInt();
                            double minRating = myReader.nextDouble();
                            students.add(new Student(id,name,duration,minRating));
                    }
                }
                Collections.sort(students);
                Collections.sort(houses);

                for(int i=0;i<8;i++) {
                    for (int a = 0; a < students.size(); a++) {
                        if (!(students.get(a).isSettled()) && students.get(a).getDuration() > 0) {
                            for (int b = 0; b < houses.size(); b++) {
                                if (!(houses.get(b).isAllocated()) && (houses.get(b).getRating() >= students.get(a).getMinRating())) {
                                    houses.get(b).setDuration(students.get(a).getDuration());
                                    students.get(a).setSettled(true);
                                    break;
                                }
                            }
                        }
                    }
                    Student.durationCorrector(students);
                    House.durationCorrector(houses);
                }
/*
                for(int i=0;i< students.size();i++){
                    if(!students.get(i).isSettled()){
                        System.out.println(students.get(i).getName());
                    }
                }
                */
			}
                catch (FileNotFoundException e) {
				System.out.println("Catch - An error occurred.");
				e.printStackTrace();
			}
			String outputFileName = args[1];
			File myOutputFile = new File(outputFileName);
            try {
			      if (myOutputFile.createNewFile()) {
                      //System.out.println("File created: " + outputFileName);
			      } else {
                      System.out.println("File already exists.");
                      System.out.println("MyFileIO ends with existing output file");
			        return;
			      }
                  FileWriter myWriter = new FileWriter(outputFileName);

                  for(int i =0; i< students.size(); i++) {
                      if(!students.get(i).isSettled()){
                          myWriter.write(students.get(i).getName());
                          myWriter.write("\n");
                      }
			      }
			      myWriter.close();
            } catch (IOException e) {
                System.out.println("Catch - An error occurred.");
		      e.printStackTrace();
		    }
    }
}
