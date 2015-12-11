package day3.futures;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DiceGameManager {
	
	private CompletionService<Dice.Result>
	
	completionService=new ExecutorCompletionService<>(Executors.newFixedThreadPool(3));
	
	
	public void throwDice(String name){
		completionService.submit(new Dice(name));
	}
	public void goAhead(){
		try {
		Future<Dice.Result> taskMonitor=	completionService.take();
		Dice.Result result=taskMonitor.get();
		System.out.println(result.getName()+" : Go ahead by "+result.getValue()+" Steps");
		
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DiceGameManager diceGameManager=new DiceGameManager();
		for(int i=0;i<20;i++){
			diceGameManager.throwDice("User "+i);			
		}
		while(true)
			diceGameManager.goAhead();
	}

}
