package sk.redeemer.eclipse.jdt.sealing.working.samelevel;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream.of(new TestClassA(), new TestClassB())
			.forEach(Main::switchOverInstance);
	}
	
	static void switchOverInstance(BaseInterface instance) {
		System.out.println(
			switch (instance) {
				case TestClassA a -> "it's a TestClassA";
				case TestClassB b -> "it's a TestClassB";
				// compiler obviously understands sealed classes hierarchy since switch is considered exhaustive
			}
		);
	}

}