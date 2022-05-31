---
title: "Mouse actions"
linkTitle: "Mouse"
weight: 4
needsTranslation: true
description: >
  A representation of any pointer device for interacting with a web page.
aliases: [
"/documentation/en/support_packages/mouse_and_keyboard_actions_in_detail/",
"/documentation/support_packages/mouse_and_keyboard_actions_in_detail/"
]
---

There are only 3 actions that can be accomplished with a mouse:
pressing down on a button, releasing a pressed button, and moving the mouse.
Selenium provides convenience methods that combine these actions in the most common ways.

## Click and hold

This method combines moving the mouse to the center of an element with pressing the left mouse button.
This is useful for focusing a specific element:

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L22-L25" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L11-L14" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L17-L20" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L9-L12" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Click and release

This method combines moving to the center of an element with pressing and releasing the left mouse button.
This is otherwise known as "clicking":

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L34-L37" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L23-L26" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L30-L33" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L20-L23" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Alternate Button Clicks

There are a total of 5 defined buttons for a Mouse:
* 0 — Left Button (the default)
* 1 — Middle Button (currently unsupported)
* 2 — Right Button
* 3 — X1 (Back) Button
* 4 — X2 (Forward) Button

### Context Click

This method combines moving to the center of an element with pressing and releasing the right mouse button (button 2).
This is otherwise known as "right-clicking":

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L46-L49" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L34-L37" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L43-L46" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L31-L34" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

### Back Click

There is no convenience method for this, it is just pressing and releasing mouse button 3

{{< tabpane disableCodeBlock=true height="7" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L60-L66" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L48-L51" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L55" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L44-L47" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

### Forward Click

There is no convenience method for this, it is just pressing and releasing mouse button 4

{{< tabpane disableCodeBlock=true height="7" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L78-L84" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L62-L65" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L61" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L58-L61" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Double click

This method combines moving to the center of an element with pressing and releasing the left mouse button twice.

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L93-L96" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L73-L76" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L69-L72" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L69-L72" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Move to element

This method moves the mouse to the in-view center point of the element. 
This is otherwise known as "hovering."
Note that the element must be in the viewport or else the command will error.

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L105-L108" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L84-L87" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L82-L85" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L80-L83" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Move by offset

These methods first move the mouse to the designated origin and then
by the number of pixels in the provided offset.
Note that the position of the mouse must be in the viewport or else the command will error.

### Offset from Element (Top Left Origin)

This method moves the mouse to the in-view center point of the element
then attempts to move to the upper left corner of the element and then moves by the
provided offset.

This will be removed as an option in Selenium 4.3, and only an offset from center of the element
will be supported. As of Selenium 4.2, this is the default behavior for Ruby, .NET and Python in order
to be backwards compatible with previous versions of Selenium.
This approach does not work correctly when the element is not entirely inside the viewport.

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
**Not Implemented in Java**
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L95-L98" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L95-L98" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L91-L94" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

### Offset from Element (Center Origin)

This method moves to the in-view center point of the element, 
then moves the mouse by the provided offset

This is the default behavior in Java as of Selenium 4.0, and will be the default
for the remaining languages as of Selenium 4.3.

{{< tabpane disableCodeBlock=true height="4" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L117-L120" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
**Coming in Selenium 4.3**
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L110-L113" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
**Coming in Selenium 4.3**
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

### Offset from Viewport

This method moves the mouse from the upper left corner of the current viewport by the provided
offset.

{{< tabpane disableCodeBlock=true height="6" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L131-L136" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L108-L110" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L125-L129" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L105-L107" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

### Offset from Current Pointer Location

This method moves the mouse from its current position by the offset provided by the user.
If the mouse has not previously been moved, the position will be in the upper left
corner of the viewport.
Note that the pointer position does not change when the page is scrolled.

{{< tabpane disableCodeBlock=true height="3" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L153-L155" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L125-L127" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L147-L149" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L119-L121" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Drag and Drop on Element

This method firstly performs a click-and-hold on the source element, 
moves to the location of the target element and then releases the mouse.

{{< tabpane disableCodeBlock=true height="5" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L166-L170" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L138-L142" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L161-L165" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L131-L135" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

## Drag and Drop by Offset

This method firstly performs a click-and-hold on the source element, moves to the given offset and then releases the mouse.

{{< tabpane disableCodeBlock=true height="6" >}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/MouseTest.java#L179-L184" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_mouse.py#L150-L155" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/MouseTest.cs#L175-L180" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/mouse_spec.rb#L143-L148" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}
