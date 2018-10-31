import java.io.*;

 public class Image {
    int width;
    int height;
     public byte [] data;
     public Image(int width, int height) {
        this.width = width;
        this.height = height;
        data = new byte [width*height*3];    
    }
     
   
     public void set(int x, int y, int val) {
		  
    	 //formula for image buffer
    	 int pxpos = (x*width+y)*3;
		// R bits
        data[pxpos] = (byte)(val >> 16);
		// G bits
        data[pxpos + 1] = (byte)((val >> 8 ) & 0xFF);
		// B bits
        data[pxpos + 2] = (byte)(val & 0xFF);
        
    }
     public void write(String filename) throws IOException {
        FileOutputStream outfile = new FileOutputStream(filename);
            // P6 is characters to identify PPM file
        
        
        String m= Integer.toString(width);
        String n= Integer.toString(height);       
        String PPM = String.format("P6 "+m+" "+n);
  	
            outfile.write(PPM.getBytes());
            outfile.write(32); // white space in ASCII 
            outfile.write(50); // max value 255 in ASCII
            outfile.write(53);
            outfile.write(53);
            outfile.write(10); // newline
            outfile.write(data);
            outfile.close();
     }  
}
