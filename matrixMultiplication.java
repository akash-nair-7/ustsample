package ustSample;

public class matrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A= {{2,3},{1,2}};
		int[][] B= {{2,4},{2,1}};
		int[][] C= new int[2][2];
		System.out.println("Matrix C:");
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				C[i][j]=A[i][0]*B[0][j]+A[i][1]*B[1][j];
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
