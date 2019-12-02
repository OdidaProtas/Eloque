package com.moringaschool.eloque;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChatHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;

    public ChatHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
    }

    public void bindProjects(ChatMessage project){

        TextView projectNameTextView = mView.findViewById(R.id.message_text);
//        TextView categoryTextView = mView.findViewById(R.id.category);
//        TextView projectOwner = mView.findViewById(R.id.projecOwner);
//        TextView minimumLevel = mView.findViewById(R.id.minimumLevel);
//        TextView projectPrice = mView.findViewById(R.id.projectPrice);
//
//
        projectNameTextView.setText(project.getMessageText());
//        categoryTextView.setText(project.getCategory());
//        projectOwner.setText(project.getPostedBy());
//        minimumLevel.setText(project.getLevel());
//        projectPrice.setText("Kes: "+ project.getOfferInKes());

    }


//    @Override
//    public void onClick(View v) {
//        final ArrayList<Projects> projects = new ArrayList<>();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ADDED_PROJECT).child(uid);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    projects.add(snapshot.getValue(Projects.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//                Intent intent = new Intent(mContext, ProjectDetailActivity.class);
//                intent.putExtra("position", itemPosition +"");
//                intent.putExtra("projects", Parcels.wrap(projects));
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });



}
