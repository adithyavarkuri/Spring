package model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
	private int id;
	private String name;
	private List<String> answers;
	private List<Answer> answerobj;
	private Map<String, String> answersMap;
	private Map<Answer,User> answersMapobj;  

	public Question() {
	}

	public Question(int id, String name, List<String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public Question(String name, List<Answer> answersobj) {
		super();
		this.name = name;
		this.answerobj = answersobj;
	}

	public Question(int id, String name, Map<String, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answersMap = answers;
	}
	public Question( String name, Map<Answer, User> answers) {  
	    super();  
	    this.name = name;  
	    this.answersMapobj = answers;  
	}  

	public void displayInfo() {
		System.out.println(id + " " + name);
		System.out.println("answers are:");
		Iterator<String> itr = answers.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public void displayInfoobj() {
		System.out.println(id + " " + name);
		System.out.println("answers are:");
		Iterator<Answer> itr = answerobj.iterator();
		while (itr.hasNext()) {
			Answer a = itr.next();
			System.out.println(a.toString());
		}
	}

	public void displayInfoMap() {
		System.out.println("question id:" + id);
		System.out.println("question name:" + name);
		System.out.println("Answers....");
		Set<Entry<String, String>> set = answersMap.entrySet();
		Iterator<Entry<String, String>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			System.out.println("Answer:" + entry.getKey() + " Posted By:" + entry.getValue());
		}
	}
	
	public void displayInfoMapoj(){  
	    System.out.println("question id:"+id);  
	    System.out.println("question name:"+name);  
	    System.out.println("Answers....");  
	    Set<Entry<Answer, User>> set=answersMapobj.entrySet();  
	    Iterator<Entry<Answer, User>> itr=set.iterator();  
	    while(itr.hasNext()){  
	        Entry<Answer, User> entry=itr.next();  
	        Answer ans=entry.getKey();  
	        User user=entry.getValue();  
	        System.out.println("Answer Information:");  
	        System.out.println(ans);  
	        System.out.println("Posted By:");  
	        System.out.println(user);  
	    }  
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswerobj() {
		return answerobj;
	}

	public void setAnswerobj(List<Answer> answerobj) {
		this.answerobj = answerobj;
	}

	public Map<String, String> getAnswersMap() {
		return answersMap;
	}

	public void setAnswersMap(Map<String, String> answersMap) {
		this.answersMap = answersMap;
	}

	public Map<Answer, User> getAnswersMapobj() {
		return answersMapobj;
	}

	public void setAnswersMapobj(Map<Answer, User> answersMapobj) {
		this.answersMapobj = answersMapobj;
	}  

	 public void initBean() {
	        System.out.println("Init Bean for : Question");
	    }
	     
	    public void destroyBean() {
	        System.out.println("end Bean for : Question");
	    }
	
	
	
}
