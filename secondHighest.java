package ustSample;

public class secondHighest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= new int[] {2,1,3,4,5,6,7,89,3,4};
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length-1-i;j++)
			{
				if(array[j]>array[j+1])
				{
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		System.out.println(array[array.length-2]+" is the second highest");
		
	}

}
