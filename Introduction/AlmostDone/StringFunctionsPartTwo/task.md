### Theory

You already know enough about Kotlin to solve this task! 
So let's get straight to the point.

___

### Task

**Description**: implement the `applySquaredFilter` function.
For the border symbol please use the pre-defined variable `borderSymbol`.

To make the picture prettier, add a separator between the picture and the border.
For the separator, please use the pre-defined variable `separator`.
Note, that the picture can be not a square, it means the width of the different lines in the picture can be different.
In other words, for shorter lines, you need to pad them with the `separator` to the length to make the image square.

In addition, the project already stores the `newLineSymbol` variable, which can be used to split the picture into lines.

Here's an example of the function's work:
```text
// The initial image:
┈╱▔╲▂╱╱╱╱▂╱▔╲┈┈
▕▔╲┈╱▔╲┈┈╱╲╱▔▏┈
▕▏┈▏╱▉╲┈┈╱▉╲▕▏┈
┈╲▃▏▔▔▔╲▂▂▂▕╱┈┈
┈┈┈▏┊┊┳┊╲▂╱┳▏┈┈
┈┈▕╲▂┊╰━━┻━╱┈┈┈
┈┈╱┈┈▔▔╲▂▂╱╲┈┈┈

// The final image:
######################################
# ┈╱▔╲▂╱╱╱╱▂╱▔╲┈┈ ## ┈╱▔╲▂╱╱╱╱▂╱▔╲┈┈ #
# ▕▔╲┈╱▔╲┈┈╱╲╱▔▏┈ ## ▕▔╲┈╱▔╲┈┈╱╲╱▔▏┈ #
# ▕▏┈▏╱▉╲┈┈╱▉╲▕▏┈ ## ▕▏┈▏╱▉╲┈┈╱▉╲▕▏┈ #
# ┈╲▃▏▔▔▔╲▂▂▂▕╱┈┈ ## ┈╲▃▏▔▔▔╲▂▂▂▕╱┈┈ #
# ┈┈┈▏┊┊┳┊╲▂╱┳▏┈┈ ## ┈┈┈▏┊┊┳┊╲▂╱┳▏┈┈ #
# ┈┈▕╲▂┊╰━━┻━╱┈┈┈ ## ┈┈▕╲▂┊╰━━┻━╱┈┈┈ #
# ┈┈╱┈┈▔▔╲▂▂╱╲┈┈┈ ## ┈┈╱┈┈▔▔╲▂▂╱╲┈┈┈ #
######################################
# ┈╱▔╲▂╱╱╱╱▂╱▔╲┈┈ ## ┈╱▔╲▂╱╱╱╱▂╱▔╲┈┈ #
# ▕▔╲┈╱▔╲┈┈╱╲╱▔▏┈ ## ▕▔╲┈╱▔╲┈┈╱╲╱▔▏┈ #
# ▕▏┈▏╱▉╲┈┈╱▉╲▕▏┈ ## ▕▏┈▏╱▉╲┈┈╱▉╲▕▏┈ #
# ┈╲▃▏▔▔▔╲▂▂▂▕╱┈┈ ## ┈╲▃▏▔▔▔╲▂▂▂▕╱┈┈ #
# ┈┈┈▏┊┊┳┊╲▂╱┳▏┈┈ ## ┈┈┈▏┊┊┳┊╲▂╱┳▏┈┈ #
# ┈┈▕╲▂┊╰━━┻━╱┈┈┈ ## ┈┈▕╲▂┊╰━━┻━╱┈┈┈ #
# ┈┈╱┈┈▔▔╲▂▂╱╲┈┈┈ ## ┈┈╱┈┈▔▔╲▂▂╱╲┈┈┈ #
######################################
```

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint">
   You can use the <code>applyBordersFilter</code> function to add the borders, next 
   create two <code>StringBuilder</code>s (for the top and for the bottom parts), 
   and put them row by row.
</div>

<div class="hint">
   To check how your function works, you can run it in <code>main</code> by passing the pre-defined variable <code>simba</code>.
</div>