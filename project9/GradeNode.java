// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "studentInfo.txt" and computes grade of students
//						based on the user's input.
public class GradeNode {
   private int studentId;
   private double avgGrade;
   private GradeNode nextNodeRef; // Reference to the next node                                   

   public GradeNode() {
      studentId = 0;
      avgGrade =0;
      nextNodeRef = null;
   }

   // Constructor                                                                                     
   public GradeNode(int studentId,double avgGrade) {
	  this.studentId = studentId;
      this.avgGrade = avgGrade;
      this.nextNodeRef = null;
   }

   // Constructor                                                                                     
   public GradeNode(int studentId, double avgGrade, GradeNode nextLoc) {
	   	  this.studentId = studentId;
	      this.avgGrade = avgGrade;
	      this.nextNodeRef = nextLoc;
   }

   // insertAfter
   public void insertAfter(GradeNode nodeLoc) {
      GradeNode tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = nodeLoc;
      nodeLoc.nextNodeRef = tmpNext;
   }

   // Get location pointed by nextNodeRef                                                             
   public GradeNode getNext() {
      return this.nextNodeRef;
   }

   // Print Grade information
   public void printGradeInfo() {
      System.out.println("Student Id: " + this.studentId);
      System.out.format("Average Grade : %.1f\n",this.avgGrade);
   }
   public double getAvgGrade() {
	   return this.avgGrade;
   }
}