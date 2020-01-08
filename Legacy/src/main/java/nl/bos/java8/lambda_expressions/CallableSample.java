/**
 * 
 */
package nl.bos.java8.lambda_expressions;

import java.util.concurrent.*;

import static nl.bos.java8.common.IConstants.*;

/**
 * @author bosa
 *
 */
public class CallableSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(STR_START);

		//Directly
		ExecutorService service = Executors.newSingleThreadExecutor();

		// The Anonymous way
		Callable<Integer> cAnonymous = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return INT_TEN * INT_FIVE * 1;
			}
		};
		Future<Integer> future = service.submit(cAnonymous);
		try {
			Integer result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}

		// The Lambda way
		Callable<Integer> cLambda = () -> {
			return INT_TEN * INT_FIVE * 2;
		};
		future = service.submit(cLambda);
		try {
			Integer result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
		
		//Scheduled
		ScheduledExecutorService serviceScheduled = Executors
				.newScheduledThreadPool(5);
		
		// The Anonymous way
		Callable<Integer> cScheduledAnonymous = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return INT_TEN * INT_FIVE * 3;
			}
		};
		ScheduledFuture<Integer> futureScheduled = serviceScheduled.schedule(cScheduledAnonymous, INT_FIVE, TimeUnit.SECONDS);
		try {
			Integer result = futureScheduled.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
		
		// The Lambda way
		Callable<Integer> cScheduledLambda = () -> {
			return INT_TEN * INT_FIVE * 4;
		};
		futureScheduled = serviceScheduled.schedule(cScheduledLambda, INT_FIVE, TimeUnit.SECONDS);
		try {
			Integer result = futureScheduled.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(STR_END);
	}
}