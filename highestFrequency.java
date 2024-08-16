package ustSample;

public class highestFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=new int[] {3,4,5,2,3,4,6,7,8,5,3,6,7,8,3};
		int maxFreq=0;
		int mostFreqElement=array[0];
		for(int i=0;i<array.length;i++)
		{
			int count=0;
			for(int j=0;j<array.length;j++)
			{
				if(array[i]==array[j])
					count++;
			}
			if(count>maxFreq)
			{
				maxFreq=count;
				mostFreqElement=array[i];
			}
		}
		System.out.println("Most frequent element is: "+mostFreqElement+" with frequency "+maxFreq);
	}

}
