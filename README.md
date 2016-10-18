# javadecompiler
A speical decompiler decompile class file to java file.But with it's reality action.

e.g.

```
Long l1 = 1L;
long l2 = 2L;
l1 += l2;
```

```
Long l1 = 1L;
long l2 = 2L;
L1 = L1 + new Long(l2); // which javac do a AutoBoxing
```
