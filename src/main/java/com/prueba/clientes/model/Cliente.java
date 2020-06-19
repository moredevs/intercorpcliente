package com.prueba.clientes.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Client", description = "Modelo la entidad clientes")
public class Cliente {

@ApiModelProperty(allowEmptyValue = false, example = "124554056407", name = "Id", required = false)
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@ApiModelProperty(allowEmptyValue = false, example = "Paul", name = "Id", required = true)
@NotNull
@Column(name = "nombre")
private String nombre;

@ApiModelProperty(allowEmptyValue = false, example = "Perez", name = "Id", required = true)
@NotNull
@Column(name = "apellido")
private String apellido;

@ApiModelProperty(allowEmptyValue = false, example = "24", name = "Id", required = true)
@NotNull
@Column(name = "edad")
private int edad;

@ApiModelProperty(allowEmptyValue = false, example = "2010-10-28", name = "Id", required = false)
@Column(name = "fec_muerte")
private String fec_muerte;
 
@ApiModelProperty(allowEmptyValue = false, example = "2083-12-28", name = "Id", required = true)
@NotNull
@DateTimeFormat (pattern="dd-MM-yyyy")
@Column(name = "fec_nac")
private Date  fec_nac;
}
