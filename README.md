content-assist-example is an example completion system for Eclipse. It aims at facilitating understanding the code completion framework of Eclipse (aka "content assist") and writing novel completion prototypes.

It adds one single extension to the extension point org.eclipse.jdt.ui.javaCompletionProposalComputer. This extension relies on class ExampleProposalComputer. [ExampleProposalComputer](https://github.com/monperrus/content-assist-example/blob/src/content_assist_example/ExampleProposalComputer.java) returns the same completion proposal for all contexts: "content-assist-example_foo1" (usually at the end of the list).

Documentation:

* <http://help.eclipse.org/index.jsp?topic=/org.eclipse.jdt.doc.isv/reference/extension-points/org_eclipse_jdt_ui_javaCompletionProposalComputer.html>
* <http://help.eclipse.org/index.jsp?topic=/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/ui/text/java/IJavaCompletionProposalComputer.html>


