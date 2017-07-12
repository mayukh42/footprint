# footprint

A simple serialization library in Java. Objects are marshalled as JSON files, and unmarshalled from them. Uses jparse JSON parser (https://github.com/mayukh42/jparse) for parsing JSON files during unmarshalling. 

Object graph is constructed as a JSON graph of class, field array. Each root level object contains JSON {class: className, fields: [field]}. Each field is stored as a JSON {variable: varName, type: varType, value: string_literal} or {variable: varName, type: varType, ref: {json}}, where {json} recursively creates the object graph as required, having the same structure as root JSON. 

v0.17.7

Primitive types supported: String, Integer, Double, LocalDate. 

All other types are considered as reference types. 


TODO: Documentation, Array support
