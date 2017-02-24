public static int erFenFa(int key) {
  Arrays.sort(mDatas);
  //前指针
  int start = 0 ;
  //末指针
  int end = mDatas.length -1;
  while(true){
   //中间值index
   int halfIndex = (start+ end) / 2;
   if(mDatas[halfIndex] > key){
    end = halfIndex -1;
   }else if(mDatas[halfIndex] < key){
    start = halfIndex +1;
   }else{
    return mDatas[halfIndex];
   } 
   if(start > end ){
    //没有找到
    return -1;
   }
  }
 }

