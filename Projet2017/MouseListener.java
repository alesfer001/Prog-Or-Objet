package simpleUIApp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.ubordeaux.simpleUI.KeyPress;
import fr.ubordeaux.simpleUI.MouseHandler;

public class MouseListener implements MouseHandler<Item> {

	ArrayList<Item> dragList = new ArrayList<Item>();;

	public MouseListener() {
		super();
	}

	public void mouseClicked(List<Item> arg0, KeyPress arg1) {
		System.out.println("Select " + arg0 + " " + arg1);
	}

	public void mouseDrag(List<Item> arg0, KeyPress arg1) {
		dragList = new ArrayList<Item>(arg0);
		System.out.println("Drag :" + dragList);
	}

	public void mouseDragging(List<Item> arg0, KeyPress arg1) {
		if (!arg0.isEmpty())
			System.out.println("Dragging :" + arg0);
	}

	public void mouseDrop(List<Item> arg0, KeyPress arg1) {
		System.out.println("Drag& Drop :" + dragList + " => " + arg0 + " using " + arg1.toString());
		Scanner input = new Scanner(System.in);
		if(dragList.size() > 2){
			if(dragList.get(0).getOwnerId() != -1){
				System.out.print("Input Number of ships desired (of total " + (dragList.size()-1) + "): ");
				int nbShipsDes = 0;
				try{
					nbShipsDes = input.nextInt();
				}catch(InputMismatchException e){
					System.out.println("Input error");
				}
				dragList = new ArrayList<Item>(dragList.subList(1, nbShipsDes+1));
				if(arg0.size() > 0){
					for (Item item : dragList) {
						item.setObjective(arg0.get(0));
					}			
				}
			}
		}
		if(dragList.get(0).getOwnerId() != -1){
			if(arg0.size() > 0){
				for (Item item : dragList) {
					item.setObjective(arg0.get(0));
				}			
			}
		}
	}

	public void mouseOver(List<Item> arg0, KeyPress arg1) {
		// TODO Auto-generated method stub

	}

	public void mouseWheelMoved(List<Item> arg0, KeyPress arg1, int arg2) {
		// TODO Auto-generated method stub
		System.out.println(arg0 + " using " + arg1.toString() + " wheel rotate " + arg2);
	}

}
