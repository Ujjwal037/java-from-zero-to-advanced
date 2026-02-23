### Week 7 Day 1: JVM Architecture
- JVM components
- Heap vs Stack
- Method Area / Metaspace
- Stack frames
- StackOverflow vs OOM

### Week 7 Day 2: Heap & Garbage Collection
- Young Generation (Eden, Survivor)
- Old Generation
- Minor vs Major vs Full GC
- Reachability Analysis
- GC Roots
- Mark & Sweep
- Copying algorithm
- Overview of GC types

### Week 7 Day 3: G1 GC Deep Dive
- Region-based heap
- Young GC
- Concurrent marking
- Mixed GC
- Humongous objects
- Stop-the-world phases
- GC tuning parameters
- Reading GC logs

### Week 7 Day 4: ZGC & Shenandoah
- Ultra-low latency GC
- Colored pointers (ZGC)
- Brooks pointer (Shenandoah)
- Concurrent relocation
- Pause-time independence from heap size
- When to use which GC

### Week 7 Day 5: JVM Memory Model Deep Dive
- Visibility problem
- Instruction reordering
- Happens-before rules
- volatile semantics
- Final field guarantees
- Memory barriers
- Double-checked locking fix

### Week 7 Day 6: Class Loading Mechanism
- Loading, Linking, Initialization
- Verification, Preparation, Resolution
- Bootstrap, Platform, Application loaders
- Parent delegation model
- Metaspace
- ClassLoader memory leaks
- Static initialization orderClassLoaderDemo
