package dungeon174;


public class Solution {
	public void print2Darray(int [][]d){
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d[0].length;j++)
				System.out.print(d[i][j]+" ");				
			System.out.println();			
		}
		System.out.println();	
	}
	
	public int helper1(int[][] d){
		print2Darray(d);
		//	System.out.println("d0length:"+d[0].length+" i:"+i);
		//	System.out.println("dolength:"+d.length+" j:"+j);
		    int x = d.length; int y = d[0].length;
		    d[x-1][y-1]=Math.max(-d[x-1][y-1],0)+1;
		    //System.out.println(d[x-1][y-1]);
		    int count=Math.min(x, y);
		    //System.out.println("count:"+count);
		    for(int i=0;i < count;i++){
		    	if(i==0){
		    		for(int j=x-2;j>=0;j--) d[j][y-1]=Math.max(d[j+1][y-1]-d[j][y-1],1);
		    		for(int k=y-2;k>=0;k--) d[x-1][k]=Math.max(d[x-1][k+1]-d[x-1][k],1);
		    		//print2Darray(d);
		    	}
		    	else{//zong
		    		for(int j=x-1-i;j>=0;j--) d[j][y-1-i] = Math.min( Math.max( d[j+1][y-1-i]-d[j][y-1-i] , 1 ), Math.max( d[j][y-i]-d[j][y-1-i] , 1 ));
		    		for(int k=y-1-i-1;k>=0;k--) d[x-1-i][k] = Math.min( Math.max( d[x-i][k]-d[x-1-i][k],1), Math.max(d[x-1-i][k+1]-d[x-1-i][k],1));
		    		//print2Darray(d);
		    	}
		    }
		    print2Darray(d);
		    return d[0][0];
		}

	public int calculateMinimumHP(int[][] dungeon) {
	      return helper1(dungeon);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int [][]aa={{-2,-3,3},{-5,-10,1},{10,30,-5}};				
		Solution d= new Solution();		
		System.out.println(d.calculateMinimumHP(aa));
	}
}
