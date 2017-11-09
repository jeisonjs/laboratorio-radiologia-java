# Sentecias SQL proyecto_radiodiagnostico;

SELECT * FROM `paciente`;

SELECT `nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, `correo`, `genero`, `embarazo`,`alergias` 
FROM `paciente` 
WHERE algo = ?;

DELETE FROM `paciente` WHERE algo = ?;

INSERT INTO `paciente`(`cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, 
	`correo`, `genero`, `embarazo`, `alergias`) 
VALUES (?,?,?,?,?,?,?,?,?);

INSERT INTO `paciente`(`cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, 
	`correo`, `genero`, `embarazo`, `alergias`) 
VALUES (123,"Juan","Perola","1955-2-2","0147-1456789","jejsj@gmail","Masculino",FALSE,FALSE);

UPDATE `paciente` SET `cedula`=?,`nombre`=?,`apellido`=?,`fechaNac`=?,`telefono`=?,
`correo`=?,`genero`=?,`embarazo`=?,`alergias`=?,`update_at`=NOW(),`is_active`=? 
WHERE `cedula` = ?;

UPDATE `paciente` SET `cedula`=23431062,`nombre`="Jeison",`apellido`="Perez",`fechaNac`="1995-5-25",`telefono`="0147-456789",
`correo`="jeisonj@hotmail.com",`genero`="Masculino",`embarazo`=FALSE,`alergias`=TRUE,`update_at`=NOW(),`is_active`=TRUE 
WHERE cedula = 23431062;

INSERT INTO `realiza` (`codigo`, `fecha`, `cedulaPac`, `codEstudio`, `tipoPago`) VALUES (
    NULL, '2017-06-04', '123456', '2', 'Efectivo');
    
   SELECT @ultimoEstudio :=  MAX(`codigo`) AS `codigo` FROM `realiza`;
   
   SELECT @ultimoEstudio;

   SELECT `nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, `correo`, `genero`, `embarazo`, `alergias` 
   FROM `paciente` 
   WHERE `is_active` = TRUE;

DELETE FROM `paciente` WHERE `cedula` = ?;
   UPDATE `paciente` SET `is_active` = ? WHERE `cedula` = ?;

   UPDATE `materiales` SET `nombre` = ?,`cantidad` = ?,`information` = ?,`update_at` = NOW() WHERE `codigo` = ?;

   SELECT paciente.nombre, `fecha`,`codEstudio`,`costoFinal` 
FROM `realiza` 
INNER JOIN paciente USING(`cedula`)
WHERE `cedula` = 123;

SELECT paciente.nombre, `fecha`,estudio.nombre,`costoFinal` 
FROM `realiza` 
INNER JOIN paciente USING(`cedula`)
INNER JOIN estudio  USING(codigo)
WHERE `cedula` = 123;

// Todos
SELECT `fecha`, paciente.nombre, estudio.nombre, `costoFinal`
FROM `realiza` 
INNER JOIN paciente USING(`cedula`)
INNER JOIN estudio  USING(codigo)

SELECT `fecha`,paciente.nombre,estudio.nombre,`costoFinal`
FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)
LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo
ORDER BY realiza.fecha desc

// Periodo de fechas
SELECT `fecha`, paciente.nombre, estudio.nombre,`costoFinal` 
FROM `realiza` 
INNER JOIN paciente USING(`cedula`)
INNER JOIN estudio  USING(codigo)
WHERE fecha >= '2017-06-07' AND fecha <= '2017-06-08'

SELECT `fecha`, paciente.nombre, estudio.nombre,`costoFinal` 
FROM `realiza` 
INNER JOIN paciente USING(`cedula`)
INNER JOIN estudio  USING(codigo)
WHERE fecha >= ? AND fecha <= ?;

SELECT
    `fecha`,realiza.`cedula`,paciente.nombre,`codEstudio`,`costoFinal`
FROM
    (
        `realiza`
    LEFT JOIN paciente ON realiza.cedula = paciente.cedula
    )
LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo
WHERE
    codEstudio = 7
ORDER BY
    realiza.fecha desc

# Sumatoria
SELECT `fecha`, estudio.nombre,COUNT(`codEstudio`), SUM(`costoFinal`)
FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)
LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo
WHERE estudio.codigo = 7
ORDER BY realiza.fecha desc

SELECT materiales.nombre 
FROM `utiliza` 
INNER JOIN materiales ON utiliza.codMaterial = materiales.codigo
WHERE `codEstudio` = 2;
