package sk.redeemer.eclipse.jdt.sealing.working.onefile;

import java.util.stream.Stream;

sealed interface BaseInterface permits SubInterfaceA, SubInterfaceB {}
sealed interface SubInterfaceA extends BaseInterface permits TestClassA, SubSubInterfaceA {}
sealed interface SubInterfaceB extends BaseInterface permits TestClassB {}
sealed interface SubSubInterfaceA extends SubInterfaceA permits TestClassB {}

final class TestClassA implements SubInterfaceA {}
final class TestClassB implements SubSubInterfaceA, SubInterfaceB {}

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
