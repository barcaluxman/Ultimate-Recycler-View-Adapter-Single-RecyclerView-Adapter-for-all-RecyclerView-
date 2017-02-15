# mvppatterndemo

Never Write another RecyclerView Adapter again... 
Lets Use Single RecyclerViewAdapter all over the app.. (Single .java file  )
-> clean Adapter
-> More organized and meaningful ViewHolder
-> No switch cases, or if elses to create different type of Recycler View Items 
-> Just extend your viewHolder from GurkhaViewHolder, Your adapter from GurkhaRecyclerViewAdapter, Your DTos with GurkhaDTO 



Now All you have to do is set the list of GurkhaComboDTO.

Where you can set which layour and View holder you want to use for that particular Item View 
List<GurkhaComboDTO> data ;
data.add(new GurkhaComboDto(R.layour.item_type_one,new GurkhaDTO, GurkhaViewHolder.class);
More Organized 
