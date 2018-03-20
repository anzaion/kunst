package binaryconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringAndBinary {
    private String text = null;
    private StringBuilder textBinary = null;
    private int index = 0;
	
	public Integer getIndex() {
		return index;
	}
	
	private Integer incrementIncex() {
		if(index < getTextBinary().length())
		 return index++;
		else  
	     return null;
	}

	
	public char getCurrentChar() {
		char ret = '0';
		if(index < getTextBinary().length())
		{
		  ret = textBinary.charAt(index);
		  incrementIncex();
		}
		return ret;
	}
	
	public boolean isCurrentCharOne()
	{
		boolean ret = false;
		char currentChar = getCurrentChar();
		if(currentChar == '1')
			ret = true;
		
		return ret;
	}


	public StringBuilder getTextBinary() {
		return textBinary;
	}

	public void setTextBinary(StringBuilder textBinary) {
		this.textBinary = textBinary;
		index = 0;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StringAndBinary(String fileName) {
		text = readFromFile(fileName);
		textBinary =  toBinary();
		index = 0;
	}
	
	public StringAndBinary() {
		text = "defaultText";
		textBinary =  toBinary();
		index = 0;
	}
	protected StringBuilder toBinary()
	{
		
		  byte[] bytes = text.getBytes();
		  StringBuilder binary = new StringBuilder();
		  for (byte b : bytes)
		  {
		     int val = b;
		     for (int i = 0; i < 8; i++)
		     {
		        binary.append((val & 128) == 0 ? 0 : 1);
		        val <<= 1;
		     }
		    // binary.append(' ');
		  }
		 
		return binary;
	}
	
	
	protected String readFromFile(String fileName)
	{
		String result = "";
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	result = result.concat(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		return result;
    }
	
}
