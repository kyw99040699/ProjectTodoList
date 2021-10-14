package com.todo.service;

import java.io.*;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, category, due_date, people, place;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n=====항목추가=====");
		System.out.print("카테고리를 입력해주세요: ");
		category = sc.next();
		
		System.out.print("제목을 입력해주세요: ");		
		title = sc.next();
//		if (list.isDuplicate(title)) {
//			System.out.printf("title can't be duplicate");
//			return;
//		}
		
		System.out.print("상세설명을 입력해주세요: ");
		desc = sc.next();
		
		System.out.print("마감일을 입력해주세요: ");
		due_date= sc.next();
		
		System.out.print("누구와 함께하나요?: ");
		people = sc.next();

		System.out.print("장소를 입력해주세요: ");
		place = sc.next();
		
		TodoItem t = new TodoItem(title, desc, category, due_date, people, place);
		if(list.addItem(t) > 0)
			System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		System.out.println("\n====일정삭제====");
		System.out.print("삭제할 일정의 번호를 입력하세요: ");
				
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];

		String line = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		int count;
		String index;
		for(count =0; st.hasMoreTokens(); count++) {
			index = st.nextToken();
			arr[count] = Integer.parseUnsignedInt(index);
		}

		
		for(int i=0; i<count; i++) {
			if (l.deleteItem(arr[i])>0)
				System.out.println(arr[i] + "번 삭제되었습니다");	
		}

	}


	public static void updateItem(TodoList l) {
		
		String new_title, new_desc, new_category, new_due_date, new_people, new_place;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n====일정 수정====");
		System.out.print("수정할 일정의 번호를 입력해주세요: ");
		int index = sc.nextInt();
		
		System.out.print("new title: ");
		new_title = sc.next().trim();
		System.out.print("new category: ");
		new_category = sc.next();
		sc.nextLine();
		System.out.print("new description: ");
		new_desc = sc.nextLine().trim();
		System.out.print("new due date: ");
		new_due_date = sc.nextLine().trim();
		System.out.print("new due people: ");
		new_people = sc.nextLine().trim();
		System.out.print("new due place: ");
		new_place = sc.nextLine().trim();

		TodoItem t= new TodoItem(new_title, new_desc, new_category, new_due_date, new_people, new_place);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("수정되었습니다");
	}
	
	public static void compItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n====항목 완료====");
		System.out.print("완료할 일정의 번호를 입력해주세요: ");
		
		int arr[] = new int[5];		
		
		String line = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		int count;
		String index;
		for(count =0; st.hasMoreTokens(); count++) {
			index = st.nextToken();
			arr[count] = Integer.parseUnsignedInt(index);
		}
		
		for(int i=0; i<count; i++) {	
			if (l.compItem(arr[i])>0)
				System.out.println(arr[i] + "번 변경되었습니다.");	
		}

		
	}

	public static void listAll(TodoList l) {
		System.out.println(l.getCount() + "개의 항목이 있습니다.");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void saveList(TodoList l, String filename) {
		try {
			Writer w = new FileWriter(filename);
			
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());
			}

			w.close();
			
			System.out.println("저장 완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void findList(TodoList l, String word) {
		int count = 0;
		for (TodoItem item: l.getList(word)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
		
	}
	
	public static void compList(TodoList l) {
		int count = 0;
		for (TodoItem item: l.compList()) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
		
	}

	public static void listCateAll(TodoList l) {
		int count=0;
		for (String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.printf("\n총 %d개의 카테고리가 등록되어 있습니다.", count);
		
	}

	public static void findCateList(TodoList l, String cate) {
		int count=0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.n", count);
	}

	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[전체목록, 총 %d개\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}


}
