---
title: "Pen actions"
linkTitle: "Pen"
weight: 5
description: >
  A representation of a pen stylus kind of pointer input for interacting with a web page.
---

A Pen is a type of pointer input that has most of the same behavior as a mouse, but can
also have event properties unique to a stylus. Additionally, while a mouse
has 5 buttons, a pen has 3 equivalent button states:

* 0 — Touch Contact (the default; equivalent to a left click)
* 2 — Barrel Button (equivalent to a right click)
* 5 — Eraser Button (currently unsupported by drivers)

## Using a Pen

{{< tabpane disableCodeBlock=true height="11">}}
    {{< tab header="Java" >}}
        {{< gh-codeblock path="examples/java/src/test/java/dev/selenium/actions_api/PenTest.java#L26-L34" >}}
    {{< /tab >}}
    {{< tab header="Python" >}}
        {{< gh-codeblock path="examples/python/tests/actions_api/test_pen.py#L13-L22" >}}
    {{< /tab >}}
    {{< tab header="CSharp" >}}
        {{< gh-codeblock path="examples/dotnet/SeleniumDocs/ActionsAPI/PenTest.cs#L20-L30" >}}
    {{< /tab >}}
    {{< tab header="Ruby" >}}
        {{< gh-codeblock path="examples/ruby/spec/actions_api/pen_spec.rb#L10-L18" >}}
    {{< /tab >}}
    {{< tab header="JavaScript" >}}
        // Add Code
   {{< /tab >}}
    {{< tab header="Kotlin" >}}
        // Add Code
    {{< /tab >}}
{{< /tabpane >}}

