package com.geekshirt.inventory.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@ApiModel(description = "Product Information")
@JsonPropertyOrder({ "name", "description", "sku",  "size", "color",
                    "image","upc", "unitPrice", "unitsInStock", "createdDate" })
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "DESCRIPTION")
    private String description;

    @NotEmpty
    @Column(name = "SKU")
    private String sku;

    @NotEmpty
    @Column(name = "SIZE")
    private String size;

    @NotEmpty
    @Column(name = "COLOR")
    private String color;

    @Column(name = "IMAGE")
    private String image;

    @NotEmpty
    @Column(name = "UPC")
    private String upc;

    @Min(0)
    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    @Min(0)
    @Column(name = "UNITS_IN_STOCK")
    private Integer unitsInStock;

    @ApiModelProperty(hidden = true)
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
