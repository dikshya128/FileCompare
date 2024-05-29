public class inputTextCompare extends CompareTexts {

	private String text1;
	private String text2;
		
	public inputTextCompare(String text1,String text2) {
		this.text1=text1;
		this.text2=text2;
	}
	
	@Override
	public void printResult(){
	
		StringBuilder[] textDiff=compareText(text1, text2);
		StringBuilder text1Diff= textDiff[0];
		StringBuilder text2Diff= textDiff[1];
		
		System.out.println("\nThe differences in the provided two input texts are as below:\n");
		
		System.out.println("Text1:"+text1Diff+'\n');
		System.out.println("Text2:"+text2Diff+'\n'+'\n');
	}
	
}
