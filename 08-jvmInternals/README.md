### Week 8 Day 1: JVM Monitoring Tools
- jps (process listing)
- jstat (GC monitoring)
- jinfo (JVM flags)
- jcmd (all-in-one tool)
- Interpreting GC metrics
- Production monitoring workflow

### Week 8 Day 2: Thread Dumps (jstack)
- Taking thread dump (jstack, jcmd)
- Thread states (RUNNABLE, BLOCKED, WAITING)
- Deadlock detection
- Lock ownership analysis
- Debugging patterns (CPU, DB, locks)
- Real production workflow

### Week 8 Day 3: Heap Dumps & Memory Leaks
- jmap / jcmd heap dump
- Shallow vs retained size
- GC roots
- Dominator tree
- Memory leak patterns
- MAT analysis workflow
- Production debugging steps

### Week 8 Day 4: Java Flight Recorder (JFR)
- Event-based JVM profiling
- CPU, GC, thread, memory events
- jcmd JFR.start / stop
- Recording analysis using JMC
- Production-safe profiling
- Real-world debugging use cases

### Week 8 Day 5: Java Mission Control (JMC)
- JFR analysis tool
- CPU flame graph
- Memory allocation profiling
- GC visualization
- Thread & lock analysis
- Event correlation
- Real debugging workflow

### Week 8 Day 6: Memory Leak Debugging
- Heap vs Metaspace leaks
- ThreadLocal leak
- Cache leak
- ClassLoader leak
- Native memory leak
- Heap dump analysis strategy
- Production debugging checklist