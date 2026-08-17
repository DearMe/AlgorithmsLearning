# AlgorithmsLearning

A plain Java "algorithms learning" project (sorting, search/BST, graph, collections). It is an IntelliJ IDEA module (`AlgorithmsLearning.iml`), **not** a Maven/Gradle project — there is no build tool and no third-party dependency manager. Sources live under `src/`, organized by package (`sort`, `search`, `collections`, `Graph`, `myuitl`, `test`).

The `docs/` folder contains unrelated Chinese-language handoff notes for a separate "东鹏H5" activity project; it is not connected to the Java code here.

## Cursor Cloud specific instructions

- **Toolchain:** JDK is preinstalled (`java`/`javac`, currently OpenJDK 21). There are no dependencies to install, so no package-install step is needed to work on this repo.
- **Source encoding gotcha:** several `.java` files contain GBK-encoded Chinese comments (e.g. `src/sort/MergeAdvance.java`). Plain `javac` fails with "unmappable character" errors. Always compile with `-encoding GBK`.
- **JavaFX gotcha:** `src/search/RedBlackBST.java` imports `javafx.scene.shape.VLineTo`. JavaFX is not bundled with modern JDKs, so this single file will not compile out of the box. Nothing else references `RedBlackBST`, so it can be excluded from compilation. This is a pre-existing code issue, not an environment problem.
- **Build (all compilable sources):**
  ```
  rm -rf out && mkdir -p out
  find src -name '*.java' ! -name 'RedBlackBST.java' > /tmp/sources.txt
  javac -encoding GBK -d out @/tmp/sources.txt
  ```
- **Run:** entry points with a `main` method are `sort.SortCompare` (prints a Selection/Insertion timing ratio), `test.Main` (runs, no stdout), and `Graph.TestSearch` (expects graph input; not a self-contained demo). Example: `java -cp out sort.SortCompare`.
- **Lint:** there is no configured linter. The closest check is `javac -encoding GBK -Xlint:all` (warnings only).
- **Tests:** there is no test framework (no JUnit). The `main` methods above serve as manual, ad-hoc checks.
