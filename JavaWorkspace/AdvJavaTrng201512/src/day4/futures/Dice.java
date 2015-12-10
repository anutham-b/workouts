package day4.futures;

import java.util.concurrent.Callable;

public class Dice implements Callable<Dice.Result> {
	private String name;
	
		
	public Dice(String name) {
		this.name = name;
	}
	@Override
	public Result call() throws Exception {
		int random=(int)(Math.random()*6)+1;
		Result result=new Result(this.name, random);
				return result;
	}

	public static class Result{
		private String name;
		private Integer value;
		public Result(String name, Integer value) {
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		
		
		
		
		
	}

	

}
