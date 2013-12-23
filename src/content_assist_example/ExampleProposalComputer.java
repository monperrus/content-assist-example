package content_assist_example;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;

/**
 * An example code completion system
 * @author Martin Monperrus
 */
public final class ExampleProposalComputer implements IJavaCompletionProposalComputer {

  // a default constructor is required by Eclipse
  public ExampleProposalComputer() {
  }

  /** returns a list with one element which is an anonymous class */
  @Override
  public List<ICompletionProposal> computeCompletionProposals(final ContentAssistInvocationContext context, IProgressMonitor monitor) {

    List<ICompletionProposal> res = new ArrayList<ICompletionProposal>();
    res.add(new ICompletionProposal() {

      @Override
      public String getDisplayString() {
        // this is the label shown in the completion list
        return "content-assist-example_foo1";
      }

      @Override
      public String getAdditionalProposalInfo() {
        // this is the additional piece of information shown when selected
        return "content-assist-example: This is some additional info";
      }

      @Override
      public IContextInformation getContextInformation() {
        // @return the context information for this proposal or <code>null</code>
        return null;
      }

      /** Inserts the proposed completion at the cursor position */
      @Override
      public void apply(IDocument document) {
        int position = context.getViewer().getSelectedRange().x;
        String currentText = document.get();
        int index = context.getInvocationOffset();
        String before = currentText.substring(0, index);
        String after = currentText.substring(index);
        document.set(before + getDisplayString() + after);
        context.getViewer().setSelectedRange(position + getDisplayString().length() + 1, -1);
      }

      @Override
      public org.eclipse.swt.graphics.Point getSelection(IDocument document) {
        // If it returns * <code>null</code>, no new selection is set.
        return null;
      }

      @Override
      public Image getImage() {
        //  @return the image to be shown or <code>null</code> if no image is desired
        return null;
      }
    });
    return res;

  }

  @Override
  public List<IContextInformation> computeContextInformation(ContentAssistInvocationContext context, IProgressMonitor monitor) {
    return new ArrayList<IContextInformation>();
  }

  @Override
  public String getErrorMessage() {
    return "error during code completion";
  }

  @Override
  public void sessionStarted() {
    //	Informs the completion system that a content assist session has started. This call will always be followed by a sessionEnded() call, but not necessarily by calls to computeCompletionProposals or computeContextInformation.
  }

  @Override
  public void sessionEnded() {
    // Informs the completion system  that a content assist session has ended. 
  }
}
