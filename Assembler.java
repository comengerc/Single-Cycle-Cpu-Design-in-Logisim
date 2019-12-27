//Osman Mantıcı 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Assembler {
	
	
	
	
	public static String extend( int toExtend, String binary) {
		
		String extended = "";
		
		int numberOfExtendedZero = toExtend - binary.length();
		
		if(numberOfExtendedZero==0) {
			return binary;
		}
		
		if(numberOfExtendedZero<0) {
			numberOfExtendedZero=numberOfExtendedZero*(-1);
			extended=binary.substring(numberOfExtendedZero, binary.length());
			return extended;
		}else {
			for(int i=0; i<numberOfExtendedZero; i++) {
				
				extended += "0";
			
			}
			
		}
		

		extended += binary;		
		return extended;
		
	}
	
	
	public static String operate(String[] instruction) {
		String result = "";

		String opcode = "";
		String binary = "";

		if (instruction[0].equals("ADD")) {
			
			//opcode (17:14 bits)
			opcode = "1000";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//src2 register (5:2)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			//empty (1:0)
			result = result.concat("00");

		} else if (instruction[0].equals("ADDI")) {
			
			//opcode (17:14 bits)
			opcode = "1001";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//immediate sayı (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("AND")) {
			
			//opcode (17:14 bits)
			opcode = "1010";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//src2 register (5:2)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			//empty (1:0)
			result = result.concat("00");
			
		} else if (instruction[0].equals("ANDI")) {

			//opcode (17:14 bits)
			opcode = "1011";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//immediate sayı (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("LD")) {

			//opcode (17:14 bits)
			opcode = "0000";
			result = result.concat(opcode); 

			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//address (9:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(10, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("ST")) {

			//opcode (17:14 bits)
			opcode = "0111";
			result = result.concat(opcode); 

			
			//src register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//address (9:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(10, binary);
			result = result.concat(binary);
						
		} else if (instruction[0].equals("JMP")) {

			//opcode (17:14 bits)
			opcode = "0101";
			result = result.concat(opcode); 

			
			//address 14 (13:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1])); 
			binary = extend(14, binary);
			result = result.concat(binary);
						
		} else if (instruction[0].equals("OR")) {
			
			//opcode (17:14 bits)
			opcode = "1100";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
		
			
			//src2 register (5:3)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			//empty (1:0)
			result = result.concat("00");

			
		} else if (instruction[0].equals("ORI")) {

			//opcode (17:14 bits)
			opcode = "1101";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//immediate sayı (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("XOR")) {
			
			//opcode (17:14 bits))
			opcode = "1110";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			
			//src2 register (3:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			//empty (1:0)
			result = result.concat("00");
			
		} else if (instruction[0].equals("XORI")) {

			//opcode (17:14 bits)
			opcode = "1111";
			result = result.concat(opcode); 
			
			
			//dst register (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//src1 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
		
			
			//immediate sayı (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("BEQ")) {

			//opcode (17:14 bits)
			opcode = "0010";
			result = result.concat(opcode); 
			
			
			//op1 (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//op2 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			//address 4 (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
			
		} else if (instruction[0].equals("BGT")) {

			//opcode (17:14 bits)
			opcode = "0001";
			result = result.concat(opcode); 
			
			
			//op1 (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//op2 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			//address 4 (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
						
		} else if (instruction[0].equals("BLT")) {

			//opcode (17:14 bits)
			opcode = "0100";
			result = result.concat(opcode); 
			
			
			//op1 (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//op2 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			//address 4 (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
						
		} else if (instruction[0].equals("BGE")) {

			//opcode (17:14 bits)
			opcode = "0011";
			result = result.concat(opcode); 
			
			
			//op1 (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//op2 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			//address 4 (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
						
		} else if (instruction[0].equals("BLE")) {

			//opcode (17:14 bits)
			opcode = "0110";
			result = result.concat(opcode); 
			
			
			//op1 (13:10)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[1]));
			binary = extend(4, binary); 
			result = result.concat(binary);
			
			
			//op2 register (9:6)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[2])); 
			binary = extend(4, binary);
			result = result.concat(binary);
			
			//address 4 (5:0)
			binary = Integer.toBinaryString(Integer.parseInt(instruction[3])); 
			binary = extend(6, binary);
			result = result.concat(binary);
						
		}

		int decimal = Integer.parseInt(result,2);
		result = Integer.toString(decimal,16);
		
		result = extend(5, result);
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {

		List<String> instructions = new ArrayList<String>();

		PrintStream o = new PrintStream(new File("output.txt"));

		PrintStream console = System.out;

		// TODO Auto-generated method stub
		try (FileReader reader = new FileReader("input.txt"); BufferedReader br = new BufferedReader(reader)) {
			// read line by line
			String line;
			String[] splitted = null;
			String binary = "";
//			 Assign o to output stream
			System.setOut(o);


			System.out.println("v2.0 raw");
			while ((line = br.readLine()) != null) {

				line=line.replace("#".toString(), "");

				splitted = line.split("\\s+|,\\s*|\\.\\s*");
				
				for(int i=1; i<splitted.length; i++) {
					splitted[i] = splitted[i].replace("R".toString(), "");
				}
				
				binary = operate(splitted);
				System.out.print(binary);
				System.out.print(" ");

				splitted = null;
			}


		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}

}
