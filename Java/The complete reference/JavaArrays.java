class JavaArrays 
{
	public static void main(String[] args) {


		int[][][][]a = {
			{{{1, 2, 3},{4, 5, 6, 9},{7}},{{7,9,10},{11}}},
			{{{5,2},{6,2}},{{1,2}}},
			{{{32,45},{45,45},{93,23}}},
		};

		System.out.println(a[2][0][2][1]);
		System.out.println(a[1][1][0][1]);
	
		for(int[][][] array3D:a)
		{
			for (int[][] array2D:array3D)
			{
				for (int[] array1D:array2D)
				{
					for (int value:array1D)
					{
						System.out.print(value+"  ");
					}
					System.out.println();
				}
			}
			System.out.println();
		}

	}
}



// a[][][][]=
// {
// 	{{{6,7},{23,45}}},
// 	{{{9,8}},{{1,2}}},
// 	{{{12,34,45}}}
// }

// 23
// 2
// 1  2  3
// 4  5  6  9
// 7
// 7  9  10
// 11

// 5  2
// 6  2
// 1  2

// 32  45
// 45  45
// 93  23
