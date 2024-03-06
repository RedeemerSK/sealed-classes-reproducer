package sk.redeemer.eclipse.jdt.sealing.working.samelevel;

public sealed interface SubInterfaceA extends BaseInterface permits TestClassA, SubSubInterfaceA, SubSubInterfaceB {

}
