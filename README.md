# Reproducing issue
Open `sk/redeemer/eclipse/jdt/sealing/SubSubInterfaceA.java` file in Eclipse IDE,
you will see 2 errors reported:
- on 'SubSubInterfaceA': `The hierarchy of the type SubSubInterfaceA is inconsistent`
- on 'TestClassB': `Permitted type TestClassB does not declare sk.redeemer.eclipse.jdt.sealing.SubSubInterfaceA as direct super interface`

(also reported in vertical / overview ruler)

Neither `Errors` nor `Markers` view display these errors.

Source code is obviously compiled properly since it's possible to run `Main` class in the same package.
Also `switch` expression in `Main` class is properly considered exhaustive, thus it seems compiler
properly understands sealed classes hierarchy.

# Surprisingly working

## Single file
Surprisingly no errors are reported for same class hierarchy if declared in single file, see `sk.redeemer.eclipse.jdt.sealing.working.onefile.Main`.

## Same level
Also when a class (`TestClassB`) implements sealed interfaces on same 'level' within class hierarchy,
no errors are reported. See `sk.redeemer.eclipse.jdt.sealing.working.samelevel` package.