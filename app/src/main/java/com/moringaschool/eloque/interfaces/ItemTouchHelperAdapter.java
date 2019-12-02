package com.moringaschool.eloque.interfaces;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int itemPosition, int toPosition);
    void onItemDismiss(int position);
}
